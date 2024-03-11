import { firestore } from 'api/fireBase/fireBaseConfig';
import { DocumentData, WithFieldValue, addDoc, collection, doc, getDoc, getDocs, updateDoc } from 'firebase/firestore';


class HttpService{
    private static instance: HttpService;
    public static getInstance(): HttpService{
        if(!HttpService.instance){
            HttpService.instance = new HttpService()
        }
        return HttpService.instance
    }

    public async get<T>(tableName: string, id: string): Promise<T>{
        const docRef = doc(firestore, tableName, id);
        const result = await getDoc(docRef); 
        const resObj = {id: id, ...result.data()} 
        if(result.exists())  
            return resObj as T;   
        else
            return {} as T
       
    }

    public async getAll<T>(tableName: string): Promise<T[]>{
        try{
        const resultList = await getDocs(collection(firestore, tableName));
        const mappedData = resultList.docs.map(element => ({id: element.id, ...element.data()}) as T)
        return mappedData;
        }catch(error){
            console.error("Error obtaining all occurrences", error)
            return []
        }        
       
    }

    public async post<T extends WithFieldValue<DocumentData>>(tableName: string, object: T){
        const ref = collection(firestore, tableName); 
        delete object.id;
        try{
           return await addDoc(ref, object);
        }catch(error){
            console.error("Error uploading data", error)
        }
       }

       public async update<T extends WithFieldValue<DocumentData>>(tableName: string, object: T){
        const docRef = doc(firestore, tableName, object.id);
        delete object.id;
        try{
           await updateDoc(docRef, object);
        }catch(error){
            console.error("Error updating data", error)
        }
        return object;
       }

}
const httpService = HttpService.getInstance()

export default httpService
