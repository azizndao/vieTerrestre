if ("geolocation" in navigator) {
    navigator.geolocation.getCurrentPosition(
        (position) => {
            const lat = position.coords.latitude;
            const lng = position.coords.longitude;
            document.querySelector("#latitude").value = lat;
            document.querySelector("#longitude").value = lng;

            console.log(`Latitude: ${lat}, longitude: ${lng}`);
        },
        (error) => {
            console.error("Error getting user location:", error);
        }
    );
} else {
    console.error("Geolocation is not supported by this browser.");
}