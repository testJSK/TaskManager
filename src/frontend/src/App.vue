<template>
  <div class="row all-site">
    <div class="col-3 menu-panel" >      
        <div class="logo">
          <h1>LOGO</h1>
        </div>
        <hr>
        <div class="login">
          <a href="#">Admin</a>
        </div>
        <hr>
        <nav>
          <div class="menu-item">
            <router-link to="/">Home</router-link>
          </div>
          <div>
            <router-link to="/about">About</router-link>
          </div>
          <div>
            <router-link to="/panel/persons">Admin</router-link>
          </div>          
        </nav>        
      </div>
    <div class="col-9">
      <div class="info-panel">
        <router-view/>
      </div>
    </div>
  </div>
  
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
.menu-panel {
  font-weight: bold;
  font-size: 1.1rem;
  background-color:#2c3e50;
}
.menu-panel hr {
  margin: 7px;
  color: #909ba7;
}
.logo {
  padding-top: 20px;
  color: #909ba7;
}
nav {   
  /* padding: 20px; */
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
