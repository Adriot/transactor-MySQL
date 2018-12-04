export interface ISalesPerson {
    id?: number;
    salesPersonNumber?: string;
    name?: string;
    surname?: string;
}

export class SalesPerson implements ISalesPerson {
    constructor(public id?: number, public salesPersonNumber?: string, public name?: string, public surname?: string) {}
}
