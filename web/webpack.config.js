var webpack = require('webpack');
var ExtractTextPlugin = require('extract-text-webpack-plugin');
var HtmlWebpackPlugin = require('html-webpack-plugin');
var path = require('path');


var root_folder = path.resolve(__dirname, '.');

var config = {
  context: root_folder,
  entry: "./src/main.js",
  output: {
    path: "./public/app",
    publicPath: "./app/",
    filename: '[name].js'
  },

  debug: true,
  devtool: "#eval-source-map",

  module: {
    loaders: [
      {
        test: /\.jsx?$/,
        exclude: /node_modules/,
        loader: 'babel',
        query: {
          presets: ['es2015', 'react'],
          plugins: ["transform-object-rest-spread"]
        }
      },
      {
        test: /\.sass$/,
        exclude: /node_modules/,
        loader: ExtractTextPlugin.extract('css!sass')
      },
      {
        test: /\.(png|gif|woff|woff2|eot|ttf|svg|jpg|ttf\?xmfroe|eot\?xmfroe|woff\?xmfroe|svg\?xmfroe)$/,
        loader: 'file-loader?&name=[path][hash].[ext]'
      },
      {
        test: /\.css$/,
        loader: ExtractTextPlugin.extract('style-loader', 'css-loader?sourceMap!postcss-loader')
      }
    ]
  },

  plugins: [
    new ExtractTextPlugin('style.css', {
      allChunks: true
    })
  ],

  devServer: {
    contentBase: "./public/",
    colors: true,
    historyApiFallback: true,
    inline: true
  }
}

if (process.env.NODE_ENV === 'production') {
  config.devtool = false;
  //config.output.filename = '[name].[hash].js';
  //config.plugins[0] = new ExtractTextPlugin('style.[hash].css', {allChunks: true});
  config.plugins = config.plugins.concat([
    new webpack.optimize.OccurenceOrderPlugin(),
    new webpack.optimize.UglifyJsPlugin({ comments: false }),
    new webpack.DefinePlugin({
      'process.env': { NODE_ENV: JSON.stringify('production') }
    })
  ]);
}


module.exports = config;
