package com.jdelorenzo.congressapp.ui.legislators.list;

import com.jdelorenzo.congressapp.FragmentScope;
import com.jdelorenzo.congressapp.network.NetComponent;

import dagger.Component;

@FragmentScope
@Component(
    dependencies = NetComponent.class,
    modules = {LegislatorsPresenterModule.class})
public interface LegislatorsComponent {
  void inject(LegislatorsFragment fragment);
}
