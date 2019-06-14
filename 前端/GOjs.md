GOjs学习

## Diagram初始化

   * 修改属性
         * Diagram.inherit(TopRotatingTool, go.RotatingTool);
         * Diagram.inherit(ParallelRouteLink, go.Link);

## 组件箱初始化

```js
$Y(go.Palette, "myPaletteDivAdvanced",
                    {
                        maxSelectionCount: 1,
                        nodeTemplateMap: myDiagram.nodeTemplateMap,
                        layout: $Y(go.GridLayout,
                            {spacing: new go.Size(10, 10)}),
                        padding: new go.Margin(20, -30, 0, -30),
                    });
 myPalette_top =
     $Y(go.Palette, "myPaletteDiv",
         {
             maxSelectionCount: 1,
             nodeTemplateMap: myDiagram.nodeTemplateMap,
             layout: $Y(go.GridLayout,
                 {spacing: new go.Size(10, 10)}),
             padding: new go.Margin(20, -30, 0, -30),
         });
```

## 概览初始化

```js
var myOverview =
    $Y(go.Overview, "myOverviewDiv",
        {observed: myDiagram, contentAlignment: go.Spot.Center});
```

## 挂载Diagram

​     * $Y(go.Diagram, "myDiagramDiv",

//禁止滚动画布但是可以拖动画布
myDiagram.toolManager.mouseWheelBehavior = go.ToolManager.WheelNone;

## 添加监听事件

myDiagram.addDiagramListener

   *  Modified
   *  LinkRelinked
   *  ExternalObjectsDropped
   *  ObjectDoubleClicked
   *  ObjectSingleClicked

## Adornment

装饰，比如在选中的时候，和未选中的样式不一样


## lNodeTemplate

   Node节点，可以设置多个link节点
   Shape
   TextBlock

```js
myDiagram.nodeTemplateMap.add("words", wordsNodeTemplate)

var linkSelectionAdornmentTemplate =
                $Y(go.Adornment, "Link",
                    $Y(go.Shape,
                        {isPanelMain: true, fill: null, stroke: "red", strokeWidth: 0})  // 使用选择对象的strokeWidth
                );
```

## PanelLayout

```js
$(go.Panel, "Grid",
{ gridCellSize: new go.Size(100, 100) },
$(go.Shape, "BarH", { fill: "lightgreen", height: 50 })
),
```



    This is the abstract base class for all Panel Layouts, which inform the possible Panel types. It is possible to create your own Panel type by creating a subclass of PanelLayout, though this is not common and not recommended for beginners.
    By default, GoJS has 12 panel types, each corresponding to a PanelLayout subclass:
    'Position', PanelLayoutPosition
    'Horizontal', PanelLayoutHorizontal
    'Vertical', PanelLayoutVertical
    'Spot', PanelLayoutSpot
    'Auto', PanelLayoutAuto
    'Table', PanelLayoutTable
    'Viewbox', PanelLayoutViewbox
    'TableRow', PanelLayoutTableRow
    'TableColumn', PanelLayoutTableColumn
    'Link', PanelLayoutLink
    'Grid', PanelLayoutGrid
    'Graduated', PanelLayoutGraduated



Binding数据绑定

```js
//makeTwoWay双向绑定
new go.Binding("location", "loc", go.Point.parse).makeTwoWay(go.Point.stringify),
{
    selectable: true,
    isShadowed: true,
    shadowBlur: 10,
    shadowOffset: new go.Point(1, 1),
    selectionAdornmentTemplate: nodeSelectionAdornmentTemplate
}
```