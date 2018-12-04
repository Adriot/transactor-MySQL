import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { Sale } from 'app/shared/model/sale.model';
import { SaleService } from './sale.service';
import { SaleComponent } from './sale.component';
import { SaleDetailComponent } from './sale-detail.component';
import { SaleUpdateComponent } from './sale-update.component';
import { SaleDeletePopupComponent } from './sale-delete-dialog.component';
import { ISale } from 'app/shared/model/sale.model';

@Injectable({ providedIn: 'root' })
export class SaleResolve implements Resolve<ISale> {
    constructor(private service: SaleService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Sale> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<Sale>) => response.ok),
                map((sale: HttpResponse<Sale>) => sale.body)
            );
        }
        return of(new Sale());
    }
}

export const saleRoute: Routes = [
    {
        path: 'sale',
        component: SaleComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'Sales'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'sale/:id/view',
        component: SaleDetailComponent,
        resolve: {
            sale: SaleResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Sales'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'sale/new',
        component: SaleUpdateComponent,
        resolve: {
            sale: SaleResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Sales'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'sale/:id/edit',
        component: SaleUpdateComponent,
        resolve: {
            sale: SaleResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Sales'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const salePopupRoute: Routes = [
    {
        path: 'sale/:id/delete',
        component: SaleDeletePopupComponent,
        resolve: {
            sale: SaleResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Sales'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
