<template>
  <div class="row g-0 all-site">
    <div class="col-3 g-0 menu-panel" >      
      <a href="/">
				<div class="logo">
					<h1>TaskManager</h1>
				</div>
      </a>
      <hr>
      <div class="login">
        <a href="#">Admin</a>
      </div>
      <hr>
      <nav >
        <div class="menu-item">
          <router-link to="/task">Tasks</router-link>
        </div>
        <div>
          <router-link to="/about">About</router-link>
        </div>
        <div>
          <router-link to="/panel/persons">Panel</router-link>
        </div>          
      </nav> 
    </div>
    <div class="col-9  g-0 info-panel">
			<app-header></app-header>
			<app-breadcrumb :pageName="curentPage"></app-breadcrumb>
			<router-view/>
    </div>
  </div>
</template>

<script>
import AppHeader from '@/components/header/Header.vue'
import AppBreadcrumb from '@/components/header/Breadcrumb.vue'

export default{
	// name: 'App',
  components: { AppHeader, AppBreadcrumb },
  data:() =>({
    curentPage : "Tasks",
  }),
	computed: { },
	methods: { },
  
}
</script>
	name: App

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
.icon {  
  height: 1.1rem;
}
.icon-m {  
  height: 0.8rem;
}
.menu-panel {
  font-weight: bold;
  font-size: 1.1rem;
  background-color:#2c3e50;
}
.info-panel {
  background-color:rgb(232, 232, 243);
  font-size: 0.9rem;
  min-height: 150%;
}
.menu-panel a {
  text-decoration: none;

}
.menu-panel hr {
  color: #909ba7;
}
.logo {
  padding: 20px 0 1px 0;
  color: #909ba7;
}

nav {   
  background-color:#2c3e50
}

nav a {
  margin: 10px;
  font-weight: bold;
  color: #909ba7;
  display: inline-block;  
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
