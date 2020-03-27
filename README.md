# Drift
🔥 Gesture handler extension for MIT App Inventor 2 and its clones like Kodular.

## Download
Latest version of the extension (.aix) can be downloaded from the [Releases](https://github.com/Freedom-Zone/Drift/releases) tab.

## Methods

### Detect Gestures On

![](/blocks/method_register.png)

_**\(** AndroidViewComponent `component`, Number `id`**\)**_ 

Registers the specified component so that it starts detecting gestures.

Params           |  []()       
---------------- | ------- 
`component`      | **AndroidViewComponent:**  The component on which you want Drift to detect gestures.
`id`             | **Number:**  A unique number which is used to indentify the specified component when an event fires.

## Events

### Double Tapped

![](/blocks/event_dbltapped.png)

_**\(** Number `id`, Number `fingers`**\)**_ 

Fires when a double tap gesture is recognised.

Params           |  []()       
---------------- | ------- 
`id`             | **Number:**  A unique number which is used to indentify the specified component when an event fires.
`fingers`        | **Number:**  The number of fingers used to perform the gesture.

### Pinched In

![](/blocks/event_pnchdin.png)

_**\(** Number `id`, Number `fingers`, Number `duration`, Number `distance`, Number `speed`**\)**_ 

Fires when a pinching in gesture is recognised.

Params           |  []()       
---------------- | ------- 
`id`             | **Number:**  A unique number which is used to indentify the specified component when an event fires.
`fingers`        | **Number:**  The number of fingers used to perform the gesture.
`duration`       | **Number:**  The amount of time used to perform the gesture.
`distance`       | **Number:**  The distance covered by the fingers while performing the gesture.
`speed`          | **Number:**  The speed with which the gesture was performed.

### Pinched Out

![](/blocks/event_pnchdout.png)

_**\(** Number `id`, Number `fingers`, Number `duration`, Number `distance`, Number `speed`**\)**_ 

Fires when a pinching out gesture is recognised.

Params           |  []()       
---------------- | ------- 
`id`             | **Number:**  A unique number which is used to indentify the specified component when an event fires.
`fingers`        | **Number:**  The number of fingers used to perform the gesture.
`duration`       | **Number:**  The amount of time used to perform the gesture.
`distance`       | **Number:**  The distance covered by the fingers while performing the gesture.
`speed`          | **Number:**  The speed with which the gesture was performed.

### Swiped Down

![](/blocks/event_swpddwn.png)

_**\(** Number `id`, Number `fingers`, Number `duration`, Number `distance`, Number `speed`**\)**_ 

Fires when a swiping down gesture is recognised.

Params           |  []()       
---------------- | ------- 
`id`             | **Number:**  A unique number which is used to indentify the specified component when an event fires.
`fingers`        | **Number:**  The number of fingers used to perform the gesture.
`duration`       | **Number:**  The amount of time used to perform the gesture.
`distance`       | **Number:**  The distance covered by the fingers while performing the gesture.
`speed`          | **Number:**  The speed with which the gesture was performed.

### Swiped Left

![](/blocks/event_swpdlft.png)

_**\(** Number `id`, Number `fingers`, Number `duration`, Number `distance`, Number `speed`**\)**_ 

Fires when a swiping left gesture is recognised.

Params           |  []()       
---------------- | ------- 
`id`             | **Number:**  A unique number which is used to indentify the specified component when an event fires.
`fingers`        | **Number:**  The number of fingers used to perform the gesture.
`duration`       | **Number:**  The amount of time used to perform the gesture.
`distance`       | **Number:**  The distance covered by the fingers while performing the gesture.
`speed`          | **Number:**  The speed with which the gesture was performed.

### Swiped Right

![](/blocks/event_swpdrght.png)

_**\(** Number `id`, Number `fingers`, Number `duration`, Number `distance`, Number `speed`**\)**_ 

Fires when a swiping right gesture is recognised.

Params           |  []()       
---------------- | ------- 
`id`             | **Number:**  A unique number which is used to indentify the specified component when an event fires.
`fingers`        | **Number:**  The number of fingers used to perform the gesture.
`duration`       | **Number:**  The amount of time used to perform the gesture.
`distance`       | **Number:**  The distance covered by the fingers while performing the gesture.
`speed`          | **Number:**  The speed with which the gesture was performed.

### Swiped Up

![](/blocks/event_swpdup.png)

_**\(** Number `id`, Number `fingers`, Number `duration`, Number `distance`, Number `speed`**\)**_ 

Fires when a swiping up gesture is recognised.

Params           |  []()       
---------------- | ------- 
`id`             | **Number:**  A unique number which is used to indentify the specified component when an event fires.
`fingers`        | **Number:**  The number of fingers used to perform the gesture.
`duration`       | **Number:**  The amount of time used to perform the gesture.
`distance`       | **Number:**  The distance covered by the fingers while performing the gesture.
`speed`          | **Number:**  The speed with which the gesture was performed.
