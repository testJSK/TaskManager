export default ( http ) => ({
	async all(){
		let response = await http.get('tasks?parentId');
		return response.data;
	},

	// async getOne( id ){
	// 	let response = await http.get(`tasks/${id}`);
	// 	return response.data;
	// },

	// async add( task ){
	// 	console.log(task)
	// 	let response = await http.post( 'tasks', JSON.stringify(task), {
	// 		headers: {
	// 			'Content-Type': 'application/json'
	// 		}
	// 	});
	// 	return response.data;
	// },

	// async update( task ){
	// 	console.log(task)
	// 	let response = await http.post( `tasks/${task.id}`, JSON.stringify(task), {
	// 		headers: {
	// 			'Content-Type': 'application/json'
	// 		}
	// 	});
	// 	return response.data;
	// },
	
	// async allByParentId( id ){
	// 	console.log(id)
	// 	let response = await http.get(`tasks?parentId=${id}`);

	// 	return response.data;
	// }
})