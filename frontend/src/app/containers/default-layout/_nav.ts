import { INavData } from '@coreui/angular';

export const navItems: INavData[] = [
  {
    name: '',
    url: '/dashboard',
    iconComponent: { name: '' },

  },

  {
    name: 'Pre-registration poster ',
    url: '/pages/poster',
    iconComponent: { name: 'cil-pencil' }
  },
  {
    name: 'Publications',
    url: '/pages/typography',
    //linkProps: { fragment: 'someAnchor' },
    iconComponent: { name: 'cil-description' }
  },
  {
    name: 'Candidates',
    url: '/pages/candidates',
    //linkProps: { fragment: 'someAnchor' },
    iconComponent: { name: 'cil-people' }
  },
  {
    name: 'element 4',
    url: '/url1',
    //linkProps: { fragment: 'someAnchor' },
    iconComponent: { name: 'cil-drop' }
  },



];
