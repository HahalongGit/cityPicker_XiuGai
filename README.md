## cityPicker_XiuGai
### 城市选择器修改
修改了原有程序的一些东西，保留为自己的修改，以后进一步研究。  
  
  本次找到一个问题，每次选择的省，市数据后县级数据没有变化即：省-市-枞阳县。
后续还会有一些研究，谢谢项目提供者。如果有需求设置每次点击显示出上次的选中结果
我们可以在
    
    public void onChanged(WheelView wheel, int oldValue, int newValue) 
    
方法中保存一下省，市，地区的选中的newValue，这个就是选中的值。在每次初始化完成城市数据后
在setUpData()方法最后重新获取上次保存的选中值，然后设置选中的item。如：
    
    mViewProvince.setCurrentItem(provincePos);
    mViewCity.setCurrentItem(cityPos);
    mViewDistrict.setCurrentItem(distractPos);这样就OK了。  

设置默认选中的值：
  
  点击打开城市选择器，在没有滑动选择城市数据的时候，默认已经选了第一个数据如：安徽省-安庆市-枞阳县。但是点击确认没有选上数据。
研究代码发现，原作者在onChange方法中进行了赋值操作，没有滑动选择的时候默认结果是空，所以直接打开点击确认这个值是空的。  
  
  修改：若有需要可以将赋值操作提到点击的确认操作中，不再onChange方法中给pickValue赋值即可。
如：  <br/>
//CityPickerPopWindow 类中 <br/>

    showValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //不管选没选，都有默认的一个pickValue
                pickValue = mCurrentProviceName + divider + mCurrentCityName + divider + mCurrentDistrictName;
                if (cityPickListner != null) {
                    cityPickListner.pickValue(pickValue);
                }
                dismiss();
            }
        });
        `
或者：
 //CityPickerDialog 类
     
     surelView.setOnClickListener(new View.OnClickListener() {
 
                @Override
                public void onClick(View v) {
                    if (negativeClickListener != null) {
                        negativeClickListener.onClick(dialog, DialogInterface.BUTTON_POSITIVE);
                        pickValue = mCurrentProviceName + divider + mCurrentCityName + divider + mCurrentDistrictName;
                        Log.e("TAG", "选择的结果是：" + pickValue);
                        if (cityPickListner != null) {
                            cityPickListner.pickValue(pickValue);
                        }
                    }
                }
            });
