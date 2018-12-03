import { NgModule } from '@angular/core';

import { TransactorSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [TransactorSharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [TransactorSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class TransactorSharedCommonModule {}
