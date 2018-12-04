import { Moment } from 'moment';

export interface ISale {
    id?: number;
    timestamp?: Moment;
    productCode?: string;
    quantity?: number;
    subTotal?: number;
    salesPersonNumber?: string;
}

export class Sale implements ISale {
    constructor(
        public id?: number,
        public timestamp?: Moment,
        public productCode?: string,
        public quantity?: number,
        public subTotal?: number,
        public salesPersonNumber?: string
    ) {}
}
