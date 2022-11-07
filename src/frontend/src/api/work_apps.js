export default ( http ) => ({
	async all(){
		let response = await http.get('workapps');
		return response.data;
	},

	async getOne( id ){
		let response = await http.get(`workapps/${id}`);
		return response.data;
	},

	async add( workapps ){
		console.log(workapps)
		let response = await http.post( 'workapps', JSON.stringify(workapps), {
			headers: {
				'Content-Type': 'application/json'
			}
		});
		return response.data;
	},

	async update( id, workapps ){
		console.log(workapps)
		let response = await http.post( `workapps/${id}`, JSON.stringify(workapps), {
			headers: {
				'Content-Type': 'application/json'
			}
		});
		return response.data;
	}
})