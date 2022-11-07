export default () => ({
	getInStorageToken(){
		return localStorage.getItem('nameToken');
	},
	setInStorageToken(token){
		return localStorage.setItem('nameToken', token);
	}
});