import { FileHandle } from "./file-handle.model";

export class Product {
    id !: number;
    nom !: string;
    description !: string;
    prix !: number;
    dateExpiration !: Date;
    QuantiteStock !: number;
}
// dateCreated !: Date;