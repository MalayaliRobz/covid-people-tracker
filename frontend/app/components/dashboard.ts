import Component from '@glimmer/component';

interface DashboardArgs {
  selectedDate: Date
}

export default class Dashboard extends Component<DashboardArgs> {
  get selectedDateAlone() {
    return this.args.selectedDate.toLocaleDateString();
  }

  get selectedDateLong() {
    return this.args.selectedDate.toLocaleDateString('en-US', { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' });
  }
}
