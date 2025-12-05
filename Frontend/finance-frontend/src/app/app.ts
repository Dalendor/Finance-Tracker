import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';

import { NgIf, NgFor } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.html',              
  styleUrls: ['./app.scss'],
  imports: [
    MatToolbarModule,
    MatCardModule,
    MatButtonModule,
    NgIf,           
    NgFor,       
  ]
})
export class App implements OnInit {
  budgets: any[] = [];
  loading = true;

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.loadBudgets();
  }

  loadBudgets() {
    this.http.get('http://localhost:8080/api/budgets').subscribe({
      next: (data: any) => {
        this.budgets = data;
        this.loading = false;
      },
      error: (err) => {
        console.error('Fout bij ophalen:', err);
        this.loading = false;
      }
    });
  }

  openSwagger() {
    window.open('http://localhost:8080/swagger-ui.html', '_blank');
  }
}