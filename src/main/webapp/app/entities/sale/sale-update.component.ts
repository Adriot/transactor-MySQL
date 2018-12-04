import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { ISale } from 'app/shared/model/sale.model';
import { SaleService } from './sale.service';

@Component({
    selector: 'jhi-sale-update',
    templateUrl: './sale-update.component.html'
})
export class SaleUpdateComponent implements OnInit {
    sale: ISale;
    isSaving: boolean;
    timestamp: string;

    constructor(private saleService: SaleService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ sale }) => {
            this.sale = sale;
            this.timestamp = this.sale.timestamp != null ? this.sale.timestamp.format(DATE_TIME_FORMAT) : null;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        this.sale.timestamp = this.timestamp != null ? moment(this.timestamp, DATE_TIME_FORMAT) : null;
        if (this.sale.id !== undefined) {
            this.subscribeToSaveResponse(this.saleService.update(this.sale));
        } else {
            this.subscribeToSaveResponse(this.saleService.create(this.sale));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<ISale>>) {
        result.subscribe((res: HttpResponse<ISale>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
}
