export default ( http ) => ({
	async all(){
		let response = await http.get('tasktypes');
		return response.data;
	},

	async getOne( id ){
		let response = await http.get(`tasktypes/${id}`);
		return response.data;
	},

	async add( task_types ){
		console.log(task)
		let response = await http.post( 'tasktypes', JSON.stringify(task_types), {
			headers: {
				'Content-Type': 'application/json'
			}
		});
		return response.data;
	},

	async update( id, task_types ){
		console.log(task_types)
		let response = await http.post( `tasktypes/${id}`, JSON.stringify(task_types), {
			headers: {
				'Content-Type': 'application/json'
			}
		});
		return response.data;
	}
})