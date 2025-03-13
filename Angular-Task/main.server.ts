import { enableProdMode } from '@angular/core';
import { AppServerModule } from './app/app.module.server';
const production=false;
if (production) {
  enableProdMode();
}

export { AppServerModule };