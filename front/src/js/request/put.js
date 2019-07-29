import 'whatwg-fetch'  
import 'es6-promise'  
  
//将json对象拼接成 key=val&key=val 的字符串形式  
function obj2params(obj) {  
    var result = '';  
    var item;  
    for(item in obj){  
        result += '&' + item + '=' +encodeURIComponent(obj[item]);  
    }  
  
    if(result) {  
        result = result.slice(1);  
    }  
    return result;  
}  
  
//发送 post 请求（首先会发送option）  
export function put(url, paramsObj) {  
    var result = fetch(url, {  
        method: 'put',  
        mode:'cors',  
        headers: {  
            'Accept': 'application/json',  
            'Content-Type': 'application/x-www-form-urlencoded'  
        },  
        body: obj2params(paramsObj)  
    });  
  
    return result;  
}  