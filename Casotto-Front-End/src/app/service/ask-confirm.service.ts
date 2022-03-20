import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AskConfirmService {

  constructor() { }

  askConfirm(verb: string, pastVerb: string, article: string, object: string, option: string): boolean {
    if (confirm("Sei sicuro di voler" + " " + verb + " " + article + " " + object + " " + option + " ?")) {
      alert(object + " " + pastVerb + " con successo");
      return true;
    }
    alert(object + " non " + pastVerb);
    return false;
  }
}
