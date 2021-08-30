/*
 * Copyright(C) 2020-21 Application Library Engineering Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,software
 * Distributed under the License is distributed on as "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,either express or impiles.
 * See the License for the specific language governing permissions and
 * Limitations under the License.
 */
package com.developers.letstoast.slice;

import com.developers.letstoast.ResourceTable;
import com.developers.smartytoast.SmartyToast;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;

public class MainAbilitySlice extends AbilitySlice implements Component.ClickedListener {

  @Override
  public void onStart(final Intent intent) {
    super.onStart(intent);
    super.setUIContent(ResourceTable.Layout_ability_main);
    ((Button) findComponentById(ResourceTable.Id_btn_done)).setClickedListener(this);
    ((Button) findComponentById(ResourceTable.Id_btn_error)).setClickedListener(this);
    ((Button) findComponentById(ResourceTable.Id_btn_warning)).setClickedListener(this);
    ((Button) findComponentById(ResourceTable.Id_btn_connected)).setClickedListener(this);
    ((Button) findComponentById(ResourceTable.Id_btn_update)).setClickedListener(this);
    ((Button) findComponentById(ResourceTable.Id_btn_saved)).setClickedListener(this);
  }

  @Override
  public void onActive() {
    super.onActive();
  }

  @Override
  public void onForeground(final Intent intent) {
    super.onForeground(intent);
  }

  @Override
  public void onClick(final Component component) {
    final SmartyToast smartyToast = new SmartyToast(getApplicationContext());
    switch (component.getId()) {
      case ResourceTable.Id_btn_done:
        smartyToast.makeText("Done!!", SmartyToast.LENGTH_SHORT, SmartyToast.DONE);
        break;
      case ResourceTable.Id_btn_error:
        smartyToast.makeText("Error!!", SmartyToast.LENGTH_SHORT, SmartyToast.ERROR);
        break;
      case ResourceTable.Id_btn_warning:
        smartyToast.makeText("Warning!!", SmartyToast.LENGTH_SHORT, SmartyToast.WARNING);
        break;
      case ResourceTable.Id_btn_connected:
        smartyToast.makeText("Connection Established!!", SmartyToast.LENGTH_SHORT,
            SmartyToast.CONNECTED);
        break;
      case ResourceTable.Id_btn_update:
        smartyToast.makeText("Updating...!!", SmartyToast.LENGTH_SHORT, SmartyToast.UPDATE);
        break;
      case ResourceTable.Id_btn_saved:
        smartyToast.makeText("Saved..!!", SmartyToast.LENGTH_SHORT, SmartyToast.SAVED);
        break;
      default:
        break;
    }
  }
}
