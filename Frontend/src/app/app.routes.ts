import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { AllPackageComponent } from './components/all-package/all-package.component';
import { PackagePageComponent } from './components/package-page/package-page.component';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { MyBookingsComponent } from './components/my-bookings/my-bookings.component';
import { MyWishlistComponent } from './components/my-wishlist/my-wishlist.component';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { FaqComponent } from './components/faq/faq.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { NgModule } from '@angular/core';

export const routes: Routes = [
    {
        path:"",
        component:HomePageComponent
    },
    {
        path:"home",
        redirectTo:""
    },
    {
        path:"packages",
        component:AllPackageComponent
    },
    {
        path:"package/:packageID",
        component:PackagePageComponent
    },
    {
        path:"signup",
        component:SignUpComponent
    },
    {
        path:"signin",
        component:SignInComponent
    },
    {
        path:"checkout",
        component:CheckoutComponent
    },
    {
        path:"mybookings",
        component:MyBookingsComponent
    },
    {
        path:"mywishlist",
        component:MyWishlistComponent
    },
    {
        path:"admin",
        component:AdminDashboardComponent
    },
    {
        path:"faq",
        component:FaqComponent
    },
    {
        path:"**",
        component:PageNotFoundComponent

    }
];
