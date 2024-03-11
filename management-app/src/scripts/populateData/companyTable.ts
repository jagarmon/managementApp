
import httpService from "../../api/fireBase/httpService";
import { Company } from "../../interfaces/Company";

const basicData = {
 companyName: "Compañía EJEMPLO S.L",
 streetName : "Calle Imaginaria nº 42",
 city: "Valladolid",
 province: "Madrid"
}

const companyObject = {
 ...basicData,
 id:"aaaa",
 companyCIF: "B56776556",
 companyIcon: "assets/companyIcon.png", 
 postCode: "68766", 
 email: "false_email@gmail.com",
 headerText: "Inscrita en el Registro Mercantil de Zaragoza, tomo 786, hoja nº M-56.777",
 footerText:
`De acuerdo con lo que establece el reglamento europeo de protección de datos RGPD 2016/679 y la Ley Orgánica Protección de Datos y garantía de 
derechos digitales (LOPD-GDD) del 5 de diciembre de 218, le informamos de que los datos personales recogidos en este documento, serán incluídos 
en un fichero bajo responsabilidad de ${basicData.companyName} con la finalidad de cumplire con los compromisos entre ambos, pudiendo rectificar, 
u oponer sus datos personales en ${basicData.streetName}, de ${basicData.city} (${basicData.province})`
}
httpService.post<Company>('CompanyProfile', companyObject)

