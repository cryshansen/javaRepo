<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<title>
		Lazy Loading Images With AngularJS
	</title>

	<style type="text/css">

		/* Add "click" styles because newer releases of AngularJS don't seem to add the HREF value. */
		a[ ng-click ] {
			cursor: pointer ;
			text-decoration: underline ;
		}

		a.box {
			background-color: #FAFAFA ;
			border: 1px solid #CCCCCC ;
			display: block ;
			height: 200px ;
			line-height: 200px ;
			text-align: center ;
			width: 684px ;
		}

		ul.photos {
			list-style-type: none ;
			margin: 16px 0px 16px 0px ;
			padding: 0px 0px 0px 0px ;
			width: 700px ;
		}

		ul.photos:after {
			content: "" ;
			clear: both ;
			display: block ;
			height: 0px ;
		}

		li.photo {
			background-color: #FAFAFA ;
			border: 1px solid #CCCCCC ;
			border-radius: 4px 4px 4px 4px ;
			float: left ;
			margin: 0px 10px 10px 0px ;
			padding: 5px 5px 5px 5px ;
		}

		li.photo img {
			border: 1px solid #EEEEEE ;
			border-radius: 3px 3px 3px 3px ;
			display: block ;
		}

		img[ bn-lazy-src ] {
			background-image: url( "./checkered.png" ) ;
		}

	</style>
	
<style>
	.block {
	    position: absolute;
	    background: #fff;
	    /* padding: 20px; */
	    width: 300px;
	    border: 1px solid #ddd;
		/* float: left !important; */
		
    -webkit-transition: all 1s ease-in-out;
    -moz-transition: all 1s ease-in-out;
    -o-transition: all 1s ease-in-out;
    -ms-transition: all 1s ease-in-out;
    transition: all 1s ease-in-out; 
}

.vertical-center {
  min-height: 100%;
  min-height: 100vh;
  display: -webkit-box;
  display: -moz-box;
  display: -ms-flexbox;
  display: -webkit-flex;
  display: flex;
  
  
  
  -webkit-box-align: center;
  -webkit-align-items: center;
  -moz-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  width: 100%;
  -webkit-box-pack: center;
  -moz-box-pack: center;
  -ms-flex-pack: center;
  -webkit-justify-content: center;
  justify-content: center;
}
.flex-container {
  display: flex;
  flex-flow: row wrap;
  justify-content: flex-start;
}

</style>
	
	
<<!-- /head>
<body>
 -->
 <div class="flex-container" ng-controller="studioStaticGalleryController">
	<h1>
		Lazy Loading Images With AngularJS
	</h1>

	<p>
		You have {{ photos.size }} photos in your set.

		<a ng-click="rebuildSet()">Rebuild set</a>.
		<a ng-click="changeSource()">Change src</a>.
		<a ng-click="clearPhotos()">Clear</a>.
	</p>

	<a ng-show="isBoxVisible" ng-click="hideBox()" class="box">
		This is a big thing that may change,
		causing the DOCUMENT HEIGHT to change.
	</a>

	
  		<div class="block" ngClass="block" ng-repeat="photo in photos">
			<img class="w-100" bn-lazy-src="{{ photo.src }}" alt="{{photo.id}}" />
		</div>
	
		

</div>

	<!-- Load scripts. -->
<!-- 
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
	  <script data-require="angular.js@*" data-semver="1.5.0" src="https://code.angularjs.org/1.5.0/angular.js"></script>
	
	<script type="text/javascript">


		// Create an application module for our demo.
		var app = angular.module( "Demo", [] );


		// -------------------------------------------------- //
		// -------------------------------------------------- //


		// I control the root of the application.
		app.controller( "AppController", function( $scope ) {

				// I flag the visibility of the big box.
				$scope.isBoxVisible = true;

				
				$scope. colCount = 0;
				$scope. colWidth = 300;
				$scope. margin = 20;
				$scope. windowWidth = 0;
				$scope.width=300;
				$scope.studioImages = [];
				$scope.imageHeights = [];
				$scope.imageWidths = [];
				$scope.blocks = [];
				$scope.photos = [];
				
				// Build up a large set of images, all with unique
				// SRC values so that the browser cannot cache them.
				
				$scope.paramValue = $stateParams.studioId;
				var url = "StudioController?action=GALLERY&id="+$stateParams.studioId;
				console.log(url);
				
				
				$http({
					
					method: 'GET',
			
					url: url
			
					}).then(function success(response) {
			
							$scope.myWelcome = response.data;
					
							var studioVars=angular.fromJson(response.data);
							
							
							var now = ( new Date() ).getTime();
							for(var i =0; i < studioVars.length;i++){
								var studioImageObj = {};
								
								studioImageObj.id=studioVars[i].id;
								studioImageObj.width = studioVars[i].width;
								studioImageObj.height = studioVars[i].height;
								studioImageObj.imgUrl = "images/studio"+ $scope.paramValue + "/576/"+studioVars[i].image;
								$scope.studioImages.push(studioImageObj);
								$scope.imageHeights.push(studioImageObj.height);
								$scope.imageWidths.push(studioImageObj.width);

								var index = ( ( i % 3 ) + 1 );
								var version = ( now + i );

								$scope.photos.push({
									id: ( i + 1 ),
									src: ( studioImageObj.imgUrl+"?v=" + version )
								});

								
								
								
								
								
								for(var j=0; j<$scope.colCount;j++){
									$scope.blocks.push(studioImageObj.width);
								}
								
								
							}
														
							$scope.statusval = response.status;
							$scope.statustext = response.statusText;
							$scope.headers = response.headers();
			
					}, function error(response) {
						
							console.log(response.statusText);
			
					});
				
				
				
				//builds photo array in the http call
				//$scope.photos = ///buildPhotoSet( $scope.studioImages );


				// ---
				// PUBLIC METHODS.
				// ---


				// I change the SRC values of the existing photo set
				// in order to examine how changes to source will
				// affect rendered / non-rendered images.
				$scope.changeSource = function() {

					var now = ( new Date() ).getTime();

					// Update all SRC attribute to point to "1.jpg".
					for ( var i = 0 ; i < $scope.photos.length ; i++ ) {

						var photo = $scope.photos[ i ];

						photo.src = photo.src.replace( /\d\./i, "1." );

					}

				};


				// I clear the current photo set.
				$scope.clearPhotos = function() {

					$scope.photos = [];

				};


				// I hide the big box, allowing the document to change
				// its dimensions (and possibly show more images than
				// were visible beforehand).
				$scope.hideBox = function() {

					$scope.isBoxVisible = false;

				};


				// I rebuild the entire photo set.
				$scope.rebuildSet = function() {

					$scope.photos = buildPhotoSet( 20 );

				};


				// ---
				// PRIVATE METHODS.
				// ---


				// I return a photo set of the given size. Each photo
				// will have a unique SRC value.
				function buildPhotoSet( imageArr ) {

					var photos = [];
					var now = ( new Date() ).getTime();

					for ( var i = 0 ; i < size ; i++ ) {

						var index = ( ( i % 3 ) + 1 );
						var version = ( now + i );

						photos.push({
							id: ( i + 1 ),
							src: ( "christina-cox-" + index + ".jpg?v=" + version )
						});

					}

					return( photos );

				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				

			}
		);


		// -------------------------------------------------- //
		// -------------------------------------------------- //


		// I lazily load the images, when they come into view.
		app.directive( "bnLazySrc", function( $window, $document ) {


				// I manage all the images that are currently being
				// monitored on the page for lazy loading.
				var lazyLoader = (function() {

					// I maintain a list of images that lazy-loading
					// and have yet to be rendered.
					var images = [];

					// I define the render timer for the lazy loading
					// images to that the DOM-querying (for offsets)
					// is chunked in groups.
					var renderTimer = null;
					var renderDelay = 100;

					// I cache the window element as a jQuery reference.
					var win = $( $window );

					// I cache the document document height so that
					// we can respond to changes in the height due to
					// dynamic content.
					var doc = $document;
					var documentHeight = doc.height();
					var documentTimer = null;
					var documentDelay = 2000;

					// I determine if the window dimension events
					// (ie. resize, scroll) are currenlty being
					// monitored for changes.
					var isWatchingWindow = false;


					// ---
					// PUBLIC METHODS.
					// ---


					// I start monitoring the given image for visibility
					// and then render it when necessary.
					function addImage( image ) {

						images.push( image );

						if ( ! renderTimer ) {

							startRenderTimer();

						}

						if ( ! isWatchingWindow ) {

							startWatchingWindow();

						}

					}


					// I remove the given image from the render queue.
					function removeImage( image ) {

						// Remove the given image from the render queue.
						for ( var i = 0 ; i < images.length ; i++ ) {

							if ( images[ i ] === image ) {

								images.splice( i, 1 );
								break;

							}

						}

						// If removing the given image has cleared the
						// render queue, then we can stop monitoring
						// the window and the image queue.
						if ( ! images.length ) {

							clearRenderTimer();

							stopWatchingWindow();

						}

					}


					// ---
					// PRIVATE METHODS.
					// ---


					// I check the document height to see if it's changed.
					function checkDocumentHeight() {

						// If the render time is currently active, then
						// don't bother getting the document height -
						// it won't actually do anything.
						if ( renderTimer ) {

							return;

						}

						var currentDocumentHeight = doc.height();

						// If the height has not changed, then ignore -
						// no more images could have come into view.
						if ( currentDocumentHeight === documentHeight ) {

							return;

						}

						// Cache the new document height.
						documentHeight = currentDocumentHeight;

						startRenderTimer();

					}


					// I check the lazy-load images that have yet to
					// be rendered.
					function checkImages() {

						// Log here so we can see how often this
						// gets called during page activity.
						console.log( "Checking for visible images..." );

						var visible = [];
						var hidden = [];

						// Determine the window dimensions.
						var windowHeight = win.height();
						var scrollTop = win.scrollTop();

						// Calculate the viewport offsets.
						var topFoldOffset = scrollTop;
						var bottomFoldOffset = ( topFoldOffset + windowHeight );

						// Query the DOM for layout and seperate the
						// images into two different categories: those
						// that are now in the viewport and those that
						// still remain hidden.
						for ( var i = 0 ; i < images.length ; i++ ) {

							var image = images[ i ];

							if ( image.isVisible( topFoldOffset, bottomFoldOffset ) ) {

								visible.push( image );

							} else {

								hidden.push( image );

							}

						}

						// Update the DOM with new image source values.
						for ( var i = 0 ; i < visible.length ; i++ ) {

							visible[ i ].render();

						}

						// Keep the still-hidden images as the new
						// image queue to be monitored.
						images = hidden;

						// Clear the render timer so that it can be set
						// again in response to window changes.
						clearRenderTimer();

						// If we've rendered all the images, then stop
						// monitoring the window for changes.
						if ( ! images.length ) {

							stopWatchingWindow();

						}

					}


					// I clear the render timer so that we can easily
					// check to see if the timer is running.
					function clearRenderTimer() {

						clearTimeout( renderTimer );

						renderTimer = null;

					}


					// I start the render time, allowing more images to
					// be added to the images queue before the render
					// action is executed.
					function startRenderTimer() {

						renderTimer = setTimeout( checkImages, renderDelay );

					}


					// I start watching the window for changes in dimension.
					function startWatchingWindow() {

						isWatchingWindow = true;

						// Listen for window changes.
						win.on( "resize.bnLazySrc", windowChanged );
						win.on( "scroll.bnLazySrc", windowChanged );

						// Set up a timer to watch for document-height changes.
						documentTimer = setInterval( checkDocumentHeight, documentDelay );

					}


					// I stop watching the window for changes in dimension.
					function stopWatchingWindow() {

						isWatchingWindow = false;

						// Stop watching for window changes.
						win.off( "resize.bnLazySrc" );
						win.off( "scroll.bnLazySrc" );

						// Stop watching for document changes.
						clearInterval( documentTimer );

					}


					// I start the render time if the window changes.
					function windowChanged() {

						if ( ! renderTimer ) {

							startRenderTimer();

						}

					}


					// Return the public API.
					return({
						addImage: addImage,
						removeImage: removeImage
					});

				})();


				// ------------------------------------------ //
				// ------------------------------------------ //


				// I represent a single lazy-load image.
				function LazyImage( element ) {

					// I am the interpolated LAZY SRC attribute of
					// the image as reported by AngularJS.
					var source = null;

					// I determine if the image has already been
					// rendered (ie, that it has been exposed to the
					// viewport and the source had been loaded).
					var isRendered = false;

					// I am the cached height of the element. We are
					// going to assume that the image doesn't change
					// height over time.
					var height = null;


					// ---
					// PUBLIC METHODS.
					// ---


					// I determine if the element is above the given
					// fold of the page.
					function isVisible( topFoldOffset, bottomFoldOffset ) {

						// If the element is not visible because it
						// is hidden, don't bother testing it.
						if ( ! element.is( ":visible" ) ) {

							return( false );

						}

						// If the height has not yet been calculated,
						// the cache it for the duration of the page.
						if ( height === null ) {

							height = element.height();

						}

						// Update the dimensions of the element.
						var top = element.offset().top;
						var bottom = ( top + height );

						// Return true if the element is:
						// 1. The top offset is in view.
						// 2. The bottom offset is in view.
						// 3. The element is overlapping the viewport.
						return(
								(
									( top <= bottomFoldOffset ) &&
									( top >= topFoldOffset )
								)
							||
								(
									( bottom <= bottomFoldOffset ) &&
									( bottom >= topFoldOffset )
								)
							||
								(
									( top <= topFoldOffset ) &&
									( bottom >= bottomFoldOffset )
								)
						);

					}


					// I move the cached source into the live source.
					function render() {

						isRendered = true;

						renderSource();

					}


					// I set the interpolated source value reported
					// by the directive / AngularJS.
					function setSource( newSource ) {

						source = newSource;

						if ( isRendered ) {

							renderSource();

						}

					}


					// ---
					// PRIVATE METHODS.
					// ---


					// I load the lazy source value into the actual
					// source value of the image element.
					function renderSource() {

						element[ 0 ].src = source;

					}


					// Return the public API.
					return({
						isVisible: isVisible,
						render: render,
						setSource: setSource
					});

				}


				// ------------------------------------------ //
				// ------------------------------------------ //


				// I bind the UI events to the scope.
				function link( $scope, element, attributes ) {

					var lazyImage = new LazyImage( element );

					// Start watching the image for changes in its
					// visibility.
					lazyLoader.addImage( lazyImage );


					// Since the lazy-src will likely need some sort
					// of string interpolation, we don't want to
					attributes.$observe(
						"bnLazySrc",
						function( newSource ) {

							lazyImage.setSource( newSource );

						}
					);


					// When the scope is destroyed, we need to remove
					// the image from the render queue.
					$scope.$on(
						"$destroy",
						function() {

							lazyLoader.removeImage( lazyImage );

						}
					);

				}


				// Return the directive configuration.
				return({
					link: link,
					restrict: "A"
				});

			}
		);

	</script> -->
<!-- 
</body>
</html> -->