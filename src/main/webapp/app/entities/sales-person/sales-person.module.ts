import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { TransactorSharedModule } from 'app/shared';
import {
    SalesPersonComponent,
    SalesPersonDetailComponent,
    SalesPersonUpdateComponent,
    SalesPersonDeletePopupComponent,
    SalesPersonDeleteDialogComponent,
    salesPersonRoute,
    salesPersonPopupRoute
} from './';

const ENTITY_STATES = [...salesPersonRoute, ...salesPersonPopupRoute];

@NgModule({
    imports: [TransactorSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        SalesPersonComponent,
        SalesPersonDetailComponent,
        SalesPersonUpdateComponent,
        SalesPersonDeleteDialogComponent,
        SalesPersonDeletePopupComponent
    ],
    entryComponents: [SalesPersonComponent, SalesPersonUpdateComponent, SalesPersonDeleteDialogComponent, SalesPersonDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class TransactorSalesPersonModule {}
