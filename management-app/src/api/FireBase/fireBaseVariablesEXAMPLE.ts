import { initializeApp } from "firebase/app";
import { getFirestore } from "firebase/firestore";

export const fireBaseVariables = {
apiKey: "apiKey",
authDomain: "authDomain",
projectId: "projectId",
storageBucket: "storageBucket",
messagingSenderId: "messagingSenderId",
appId: "appId"
}
const app = initializeApp(fireBaseVariables);
export const FireStore = getFirestore(app)