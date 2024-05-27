import { UsuarioService } from './../services/usuario.service';
import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-usuario-form',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './usuario-form.component.html',
  styleUrl: './usuario-form.component.css'
})
export default class UsuarioFormComponent {
  private fb = inject(FormBuilder);
  private router = inject(Router);
  private usuarioService = inject(UsuarioService);

  form = this.fb.group({
    nome: ['', [Validators.required]],
    cpf: ['', [Validators.required]],
    urlAvatar: ['', [Validators.required]],
  });

    create() {
      // console.log(this.form.value);

      const usuario = this.form.value;
      this.usuarioService.create(usuario)
      .subscribe(() =>  {
        this.router.navigate(['/']);
      });
  }
}
