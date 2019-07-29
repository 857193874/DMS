import axios from 'axios';
import { Toast } from 'antd-mobile';

axios.interceptors.request.use(config => {
  Toast.loading('Loading', 0);
  return config;
});

axios.interceptors.response.use(config => {
  Toast.hide();
  return config;
});

axios.defaults.withCredentials = true;

export const baseURL = 'http://[2001:da8:270:2020:f816:3eff:febb:50dd]:8080/dms';
