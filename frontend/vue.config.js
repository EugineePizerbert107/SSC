const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
  transpileDependencies: ["vuetify"],
  devServer: {
    //frontend
    host: "localhost",
    //disableHostCheck: true,
    port: 8080,
    https: false,
    proxy: {
      //backend
      "/api": { target: "http://localhost:8081" },
    },
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Methods": "GET, POST, PUT, DELETE, PATCH, OPTIONS",
      "Access-Control-Allow-Headers":
        "x-Requested-With, content-type, Authorization",
    },
  },
});
