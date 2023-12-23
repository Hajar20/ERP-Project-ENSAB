import { INavData } from '@coreui/angular';

export const navItems: INavData[] = [
  {
    name: 'Dashboard',
    url: '/dashboard',
    iconComponent: { name: 'cil-speedometer' },

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
    name: 'element 3',
    url: '/url',
    //linkProps: { fragment: 'someAnchor' },
    iconComponent: { name: 'cil-drop' }
  },
  {
    name: 'element 4',
    url: '/url1',
    //linkProps: { fragment: 'someAnchor' },
    iconComponent: { name: 'cil-drop' }
  },



];
