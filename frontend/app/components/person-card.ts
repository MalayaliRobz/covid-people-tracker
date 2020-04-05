import Component from '@glimmer/component';

interface PersonCardArgs {}

export default class PersonCard extends Component<PersonCardArgs> {
  get randomAvar() {
    let randomNo = Math.floor(Math.random() * (8 - 1) + 1);
    
    return `/icons/avatar-${randomNo}.svg`;
  }
}
