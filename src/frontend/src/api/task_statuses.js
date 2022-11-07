export default ( http ) => ({
	async all(){
		let response = await http.get('taskstatuses');
		return response.data;
	},

	async getOne( id ){
		let response = await http.get(`taskstatuses/${id}`);
		return response.data;
	},

	async add( task_statuses ){
		// console.log(task)
		let response = await http.post( 'taskstatuses', JSON.stringify(task_statuses), {
			headers: {
				'Content-Type': 'application/json'
			}
		});
		return response.data;
	},

	async update( id, task_statuses ){
		console.log(task_statuses)
		let response = await http.post( `taskstatuses/${id}`, JSON.stringify(task_statuses), {
			headers: {
				'Content-Type': 'application/json'
			}
		});
		return response.data;
	}
})