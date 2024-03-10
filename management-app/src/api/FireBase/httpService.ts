import { firestore } from 'api/FireBase/firebaseConfig';
import { DocumentData, WithFieldValue, addDoc, collection, doc, getDoc, getDocs } from 'firebase/firestore';
class HttpService{
    private static instance: HttpService;
    public static getInstance(): HttpService{
        if(!HttpService.instance){
            HttpService.instance = new HttpService()
        }
        return HttpService.instance
    }

    public async get<T extends WithFieldValue<DocumentData>>(tableName: string, id: string): Promise<T>{
        const docRef = doc(firestore, tableName, id);
        const result = await getDoc(docRef);  
        if(result.exists())  
            return result.data() as T;   
        else
            return {} as T
       
    }

    public async getAll<T extends WithFieldValue<DocumentData>>(tableName: string): Promise<T[]>{
        const resultList = await getDocs(collection(firestore, tableName));
        const mappedData = resultList.docs.map(element => element.data() as T)
        return mappedData;
    }

    public async post<T extends WithFieldValue<DocumentData>>(tableName: string, object: T){
        const ref = collection(firestore, tableName); 
        try{
            await addDoc(ref, object);
        }catch(error){
            console.error("Error uploading data")
        }
        return object;
       }

}
const httpService = HttpService.getInstance()

export default httpService
