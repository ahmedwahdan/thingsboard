
///
/// Copyright © 2016-2020 The Thingsboard Authors
///
/// Licensed under the Apache License, Version 2.0 (the "License");
/// you may not use this file except in compliance with the License.
/// You may obtain a copy of the License at
///
///     http://www.apache.org/licenses/LICENSE-2.0
///
/// Unless required by applicable law or agreed to in writing, software
/// distributed under the License is distributed on an "AS IS" BASIS,
/// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
/// See the License for the specific language governing permissions and
/// limitations under the License.
///

import { Component, OnInit } from '@angular/core';
import { AuthService } from '@core/auth/auth.service';
import { Store } from '@ngrx/store';
import { AppState } from '@core/core.state';
import { PageComponent } from '@shared/components/page.component';
import { FormBuilder } from '@angular/forms';
import { ActionNotificationShow } from '@core/notification/notification.actions';
import { TranslateService } from '@ngx-translate/core';
import { Router } from '@angular/router';

@Component({
  selector: 'tb-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent extends PageComponent implements OnInit {

  registrationRequest = this.fb.group({
    firstName: [''],
    lastName: [''],
    email: [''],
    password: ['']
  });

  constructor(protected store: Store<AppState>,
              private authService: AuthService,
              private translate: TranslateService,
              public fb: FormBuilder) {
    super(store);
  }

  ngOnInit() {
  }

  register() {
    this.authService.register(this.registrationRequest.value).subscribe(
      () => {
        this.store.dispatch(new ActionNotificationShow({ message: this.translate.instant('login.activation_mail_was_sent'),
          type: 'success' }));
      }
    );
  }


}
