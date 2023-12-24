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
    url: '/pages/publication',
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
    name: 'File handling',
    url: '/pages/uploadExcelFile',
    //linkProps: { fragment: 'someAnchor' },
    iconComponent: { name: 'cil-file' }
  },


];
