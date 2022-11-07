export default ( http ) => ({
	async all(){
		let response = await http.get('persons');		
		return response.data;
	},

	async getOne(id){
		let response = await http.get(`persons/${id}`);
		return response.data;
	},

	async add( person ){
		let response = await http.post( 'persons', JSON.stringify(person), {
			headers: {
				'Content-Type': 'application/json'
			}
		});		
		return response.data;
	},

	async update( id, person){
		let response = await http.post(`persons/${id}`, JSON.stringify(person) ,{
			headers: {
				'Content-Type': 'application/json'
			}
		});		
		response.data;
	}
})
