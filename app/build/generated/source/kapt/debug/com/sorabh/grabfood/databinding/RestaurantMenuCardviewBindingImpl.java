package com.sorabh.grabfood.databinding;
import com.sorabh.grabfood.R;
import com.sorabh.grabfood.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class RestaurantMenuCardviewBindingImpl extends RestaurantMenuCardviewBinding implements com.sorabh.grabfood.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final com.google.android.material.card.MaterialCardView mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback4;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public RestaurantMenuCardviewBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private RestaurantMenuCardviewBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.google.android.material.button.MaterialButton) bindings[4]
            , (com.google.android.material.textview.MaterialTextView) bindings[3]
            , (com.google.android.material.textview.MaterialTextView) bindings[2]
            , (com.google.android.material.textview.MaterialTextView) bindings[1]
            );
        this.btnRestaurantMenuAdd.setTag(null);
        this.mboundView0 = (com.google.android.material.card.MaterialCardView) bindings[0];
        this.mboundView0.setTag(null);
        this.txtRestaurantMenuFoodPrice.setTag(null);
        this.txtRestaurantMenuName.setTag(null);
        this.txtRestaurantMenuSno.setTag(null);
        setRootTag(root);
        // listeners
        mCallback4 = new com.sorabh.grabfood.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.onMenuButtonClicked == variableId) {
            setOnMenuButtonClicked((com.sorabh.grabfood.ui.adapter.RestaurantMenuViewHolder.OnMenuButtonClickedListener) variable);
        }
        else if (BR.menuData == variableId) {
            setMenuData((com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu) variable);
        }
        else if (BR.sno == variableId) {
            setSno((java.lang.String) variable);
        }
        else if (BR.view == variableId) {
            setView((com.sorabh.grabfood.databinding.RestaurantMenuCardviewBindingImpl) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setOnMenuButtonClicked(@Nullable com.sorabh.grabfood.ui.adapter.RestaurantMenuViewHolder.OnMenuButtonClickedListener OnMenuButtonClicked) {
        this.mOnMenuButtonClicked = OnMenuButtonClicked;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.onMenuButtonClicked);
        super.requestRebind();
    }
    public void setMenuData(@Nullable com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu MenuData) {
        this.mMenuData = MenuData;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.menuData);
        super.requestRebind();
    }
    public void setSno(@Nullable java.lang.String Sno) {
        this.mSno = Sno;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.sno);
        super.requestRebind();
    }
    public void setView(@Nullable com.sorabh.grabfood.databinding.RestaurantMenuCardviewBindingImpl View) {
        this.mView = View;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeView((com.sorabh.grabfood.databinding.RestaurantMenuCardviewBindingImpl) object, fieldId);
        }
        return false;
    }
    private boolean onChangeView(com.sorabh.grabfood.databinding.RestaurantMenuCardviewBindingImpl View, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.sorabh.grabfood.ui.adapter.RestaurantMenuViewHolder.OnMenuButtonClickedListener onMenuButtonClicked = mOnMenuButtonClicked;
        com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menuData = mMenuData;
        java.lang.String sno = mSno;
        java.lang.String menuDataCostForOne = null;
        java.lang.String menuDataName = null;

        if ((dirtyFlags & 0x14L) != 0) {



                if (menuData != null) {
                    // read menuData.cost_for_one
                    menuDataCostForOne = menuData.getCost_for_one();
                    // read menuData.name
                    menuDataName = menuData.getName();
                }
        }
        if ((dirtyFlags & 0x18L) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            this.btnRestaurantMenuAdd.setOnClickListener(mCallback4);
        }
        if ((dirtyFlags & 0x14L) != 0) {
            // api target 1

            com.sorabh.grabfood.util.binding_adapter.BindingAdapterKt.txt(this.txtRestaurantMenuFoodPrice, menuDataCostForOne);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtRestaurantMenuName, menuDataName);
        }
        if ((dirtyFlags & 0x18L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtRestaurantMenuSno, sno);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // onMenuButtonClicked
        com.sorabh.grabfood.ui.adapter.RestaurantMenuViewHolder.OnMenuButtonClickedListener onMenuButtonClicked = mOnMenuButtonClicked;
        // onMenuButtonClicked != null
        boolean onMenuButtonClickedJavaLangObjectNull = false;
        // menuData
        com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menuData = mMenuData;



        onMenuButtonClickedJavaLangObjectNull = (onMenuButtonClicked) != (null);
        if (onMenuButtonClickedJavaLangObjectNull) {



            onMenuButtonClicked.onMenuButtonClicked(menuData);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): view
        flag 1 (0x2L): onMenuButtonClicked
        flag 2 (0x3L): menuData
        flag 3 (0x4L): sno
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}