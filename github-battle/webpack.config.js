var path = require('path');

var HTMLWebpackPlugin = require('html-webpack-plugin');
var HTMLWebpackPluginConfig = new HTMLWebpackPlugin({
	template: path.join(__dirname,'app/index.html'),
	filename: 'index.html',
	inject: 'body'
});

module.exports = {
	entry: [
		'./app/index.js'
	],
	output: {
		path: path.join(__dirname, 'dist'),
		filename: "index_bundle.js"
	},
	module: {
		loaders: [{test: /\.js$/, include: path.join(__dirname, 'app'),loader: "babel-loader"},]
	},
	plugins: [HTMLWebpackPluginConfig]
};