import { Component, OnInit } from '@angular/core';
import { LicenseManager } from 'primeng/api';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html'
})
export class AppComponent implements OnInit {

    constructor(private licenseManager: LicenseManager) {}

    ngOnInit() {
        this.licenseManager.verify('LICENSE_KEY', 'PASS_KEY');
    }
}