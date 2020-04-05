import Controller from '@ember/controller';
import { action, set} from '@ember/object';
import { tracked } from 'tracked-built-ins';
import { task } from 'ember-concurrency-decorators';
import { timeout } from 'ember-concurrency';

class Person {
  name: string | undefined;
  timeOfInteraction: string | undefined;
  placeOfInteraction: string | undefined;
  additionalInfo: string | undefined;
  userId: number;

  constructor(userId: number, timeOfInteraction: string) {
    this.timeOfInteraction = timeOfInteraction;
    this.userId = userId;
  }

  clear() { 
      set(this, 'name', undefined);
      set(this, 'placeOfInteraction', undefined);
      set(this, 'additionalInfo', undefined);
  }

  getData() {
    return {
      name: this.name,
      timeOfInteraction: Date.parse(this.timeOfInteraction),
      placeOfInteraction: this.placeOfInteraction,
      additionalInfo: this.additionalInfo,
      userId: this.userId
    }
  }

  save() {
    let data = this.getData();
    let myHeaders = new Headers();

    myHeaders.append("Content-Type", "application/json");
    
    let raw = JSON.stringify(data);
    
    let requestOptions = {
      method: 'POST',
      headers: myHeaders,
      body: raw,
      redirect: 'follow'
    };
    
    return fetch("/entity/person", requestOptions)
      .then(response => response.json())
  }
}

export default class Index extends Controller {
  constructor() {
    super(...arguments);

    this.fetchPeople.perform(new Date());
  }

  @tracked
  centerDate: Date = new Date();

  @tracked
  selectedDate: Date = new Date(new Date().toDateString());

  @tracked
  isFormExpanded : boolean = false

  @tracked
  dummyPerson : Person = new Person(1, this.formatDate(new Date()));
 
  @tracked
  peopleList  = []

  formatDate(date: Date) {
    let dd = String(date.getDate()); 
    let mm = String(date.getMonth() + 1); 
    let yyyy = String(date.getFullYear()); 

    if (parseInt(dd) < 10) { 
      dd = '0' + dd; 
  } 
  if (parseInt(mm) < 10) { 
      mm = '0' + mm; 
  }

    return `${yyyy}-${mm}-${dd}`; 
  }

  @task({ restartable: true })
  *fetchPeople(this: Index, date: Date) {
    try {
      let requestOptions = {
        method: 'GET',
        redirect: 'follow'
      };
      
      yield timeout(150);
      let response = yield fetch(`/1/persons?date=${this.formatDate(date)}`, requestOptions);
      response = yield response.json()

      // console.log(response);
      
      this.peopleList = response;
    } catch(error) {
      console.error(error);
    }
  };

  @action
  updateSelectedDate({ date } : { date: Date }) {
    this.selectedDate = date;
    this.fetchPeople.perform(date);
  }

  @action
  updateSelectedDateInForm(date: Date) { 
    this.selectedDate = date;
  }

  @action
  updateMonth({ date } : { date: Date }) {
      this.centerDate = date;
  }

  @action
  triggerFullForm() {
    this.isFormExpanded = !this.isFormExpanded;
  }

  @action
  async onPeopleFormSubmit() {
    try {
      await this.dummyPerson.save();
      this.fetchPeople.perform(new Date(this.dummyPerson.timeOfInteraction));

      this.dummyPerson.clear();
      this.isFormExpanded = false;
    } catch(error) {
      console.log("error", error);
      
    }
  }

  @action
  personFormCancel() {
    this.dummyPerson.clear();
    this.isFormExpanded = false;
  }

  @action
  async onPersonDeleteClick(person) {
    set(person, 'isDeleted', true);

    var requestOptions = {
      method: 'DELETE',
      redirect: 'follow'
    };
    
    await fetch(`/entity/person/${person.id}`, requestOptions)

    this.fetchPeople.perform(new Date(person.timeOfInteraction));
  }

  @action
  onNameInputEnter() {
    if (this.dummyPerson.name && !this.isFormExpanded) {
      this.isFormExpanded = !this.isFormExpanded;
    } else if (!this.isFormExpanded) {
      alert("Please enter a name");
    }
  }
}

// DO NOT DELETE: this is how TypeScript knows how to look up your controllers.
declare module '@ember/controller' {
  interface Registry {
    'index': Index;
  }
}
