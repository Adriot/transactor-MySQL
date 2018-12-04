import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { TransactorProductModule } from './product/product.module';
import { TransactorStockModule } from './stock/stock.module';
import { TransactorSaleModule } from './sale/sale.module';
import { TransactorSalesPersonModule } from './sales-person/sales-person.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        TransactorProductModule,
        TransactorStockModule,
        TransactorSaleModule,
        TransactorSalesPersonModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class TransactorEntityModule {}
