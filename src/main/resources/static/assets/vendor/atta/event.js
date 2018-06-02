jQuery(function ($) {
    $(".device_car div a").click(function () {
        $(this).siblings("a").removeClass('active');
        $(this).addClass('active');

        function addMarker(data) {
            var marker = new AMap.Marker({
                position: [data[1] , data[0]],
                icon: "http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png",
                title: 'location',
                map: map
            });
            marker.setMap(null)
            marker.setMap(map)
            map.setZoomAndCenter(20, [data[1], data[0]])
        }

        $.ajax({
            url: '/node/single/path',
            type: 'get',
            success: function (data) {
                console.log([data['data'][0][0]])
                addMarker(data['data'][0])
            }
        })

        var ID = setInterval(function () {
            $.ajax({
                url: '/node/single/path',
                type: 'get',
                success: function (data) {
                    console.log([data['data'][0][0]])
                    addMarker(data['data'][0])
                }
            })
        }, 20000)
    });
});