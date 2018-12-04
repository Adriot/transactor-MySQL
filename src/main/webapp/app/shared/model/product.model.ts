export interface IProduct {
    id?: number;
    productCode?: string;
    productName?: string;
    barCode?: string;
    description?: string;
    price?: number;
    imageURL?: string;
}

export class Product implements IProduct {
    constructor(
        public id?: number,
        public productCode?: string,
        public productName?: string,
        public barCode?: string,
        public description?: string,
        public price?: number,
        public imageURL?: string
    ) {}
}
