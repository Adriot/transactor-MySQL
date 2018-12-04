export interface IStock {
    id?: number;
    productCode?: string;
    supplier?: string;
    quantity?: number;
}

export class Stock implements IStock {
    constructor(public id?: number, public productCode?: string, public supplier?: string, public quantity?: number) {}
}
