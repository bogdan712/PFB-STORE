import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CategoryListComponent } from './entities/category/category-list/category-list.component';
import { ItemListComponent } from './entities/item/item-list/item-list.component';
import { ItemFormComponent } from './entities/item/item-form/item-form.component';
import { RegistrarComponent } from './log_in/registrar/registrar.component';
import { IniciarSesionComponent } from './log_in/iniciar-sesion/iniciar-sesion.component';

const routes: Routes = [
  { path: '', component: HomeComponent,pathMatch:'full'},
  { path: 'categories', component: CategoryListComponent},
  { path: 'articulos', component: ItemListComponent},
  { path: 'categories/:categoryId/items', component: ItemListComponent},
  { path: 'items/:itemId', component: ItemFormComponent},
  { path: 'register', component: RegistrarComponent},
  { path: 'login', component: IniciarSesionComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
