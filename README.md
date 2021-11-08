# Project: NASA Astronomy Picture of the Day

## Introduction

NASA Astronomy Picture of the Day, a basic app that retrieves pictures from the NASA APOD API and displays them in a list.
Clicking each item displays a detail screen.

## Notes

- The API key is stored in the local.properties file. You will need your own key.
- Example local.properties API Key entry: **apiKey="your_key"**

## Requirements
Create a single page site that lists the NASA Astronomy Picture of the Day for the past 7 days. Tapping on the list should display the image and description.

## Design
Plan to first display a list of the past seven days of images to the user. Allow the user to press a list item and display detail about the daily image.

## Implementation
The main activity will display a fragment with a recyclerview. Pressing an item list launches a detail fragment.
The textview for the description (explanation) needs to scroll due to the length of the text.

## Testing


## Discussion
This is a minimal viable product, but can be improved.

- The single activity architecture model using fragments is the current best practice. It promotes one set of interactions with the lifecycle for the app and will make it easier to implement the navigation component, etc. in future versions.
- The app should check for a network connection before making the api call. If there is no network, it crashes giving the user a bad experience.
- The date range is hardcoded in the api call (bad). The design can be improved by either allowing the user to choose a date range, or by retrieving the latest date from the API and back calculating the past seven days.
- Some daily image urls are links to video. Coil is used to load images, and needs to be configured to handle the first frame of the video. Currently, a placeholder NASA logo is used whenever there is a video url.
- The detail fragment could display more info including date, copyright, etc.
- The recyclerview sends the url for the image and the explanation as strings in a bundle when the detail fragment is launched. The Detail Fragment should use shared data.
- Navigation isn't implemented, but would improve the flow between fragments. 
- A desktop widget that shows the current picture of the day would be nice.
- A daily notification could be added when a new picture of the day is available.
