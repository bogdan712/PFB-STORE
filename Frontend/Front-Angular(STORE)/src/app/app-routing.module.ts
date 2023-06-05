import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CategoryListComponent } from './entities/category/category-list/category-list.component';
import { ItemListComponent } from './entities/item/item-list/item-list.component';
import { ItemFormComponent } from './entities/item/item-form/item-form.component';
import { RegistrarComponent } from './log_in/registrar/registrar.component';
import { IniciarSessionComponent } from './log_in/iniciar-session/iniciar-session.component';

const routes: Routes = [
  { path: '', component: HomeComponent,pathMatch:'full'},
  { path: 'categories', component: CategoryListComponent},
  { path: 'articulos', component: ItemListComponent},
  { path: 'categories/:categoryId/items', component: ItemListComponent},
  { path: 'items/:itemId', component: ItemFormComponent},
  { path: 'items/new', component: ItemFormComponent},
  { path: 'login', component: IniciarSessionComponent},
  { path: 'registrar', component: RegistrarComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
