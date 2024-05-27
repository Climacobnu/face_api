
import { UsuarioService } from './../services/usuario.service';
import { Component, OnInit, inject } from '@angular/core';
import{ RouterModule } from '@angular/router';
@Component({
  selector: 'app-usuario-list',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './usuario-list.component.html',
  styleUrl: './usuario-list.component.css'
})
export default class UsuarioListComponent implements OnInit{
  private usuarioService = inject(UsuarioService);

  usuarios: any = [] = [];

  ngOnInit(): void {
      this.usuarioService.list()
      .subscribe((usuarios: any) => {
       this.usuarios = usuarios;
      });
  }

}
