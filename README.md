# cityPicker_XiuGai
城市选择器，修改了原有程序的一些东西，保留为自己的修改，以后进一步研究。
本次找到一个问题，每次选择的省，市数据后县级数据没有变化即：省-市-枞阳县。
后续还会有一些研究，谢谢项目提供者。如果有需求设置每次点击显示出上次的选中结果
我们可以在public void onChanged(WheelView wheel, int oldValue, int newValue) 
方法中保存一下省，市，地区的选中的newValue，这个就是选中的值。在每次初始化完成城市数据后
在setUpData()方法最后重新获取上次保存的选中值，然后设置选中的item。如：
mViewProvince.setCurrentItem(provincePos);
mViewCity.setCurrentItem(cityPos);
mViewDistrict.setCurrentItem(distractPos);这样就OK了。
