package com.sorabh.grabfood.databinding;
import com.sorabh.grabfood.R;
import com.sorabh.grabfood.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class CartAdapterLayoutBindingImpl extends CartAdapterLayoutBinding implements com.sorabh.grabfood.generated.callback.OnClickListener.Listener {

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
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public CartAdapterLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private CartAdapterLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.button.MaterialButton) bindings[4]
            , (com.google.android.material.textview.MaterialTextView) bindings[2]
            , (com.google.android.material.textview.MaterialTextView) bindings[3]
            , (com.google.android.material.textview.MaterialTextView) bindings[1]
            );
        this.btnPlaceOder.setTag(null);
        this.cartAdapterName.setTag(null);
        this.cartAdapterPrice.setTag(null);
        this.cartAdapterSno.setTag(null);
        this.mboundView0 = (com.google.android.material.card.MaterialCardView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.sorabh.grabfood.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
        if (BR.menu == variableId) {
            setMenu((com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu) variable);
        }
        else if (BR.position == variableId) {
            setPosition((java.lang.String) variable);
        }
        else if (BR.onOderButtonClicked == variableId) {
            setOnOderButtonClicked((com.sorabh.grabfood.ui.adapter.CartViewHolder.OnOderButtonClickedListener) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setMenu(@Nullable com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu Menu) {
        this.mMenu = Menu;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.menu);
        super.requestRebind();
    }
    public void setPosition(@Nullable java.lang.String Position) {
        this.mPosition = Position;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.position);
        super.requestRebind();
    }
    public void setOnOderButtonClicked(@Nullable com.sorabh.grabfood.ui.adapter.CartViewHolder.OnOderButtonClickedListener OnOderButtonClicked) {
        this.mOnOderButtonClicked = OnOderButtonClicked;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.onOderButtonClicked);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        java.lang.String menuName = null;
        com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menu = mMenu;
        java.lang.String menuCostForOne = null;
        java.lang.String position = mPosition;
        com.sorabh.grabfood.ui.adapter.CartViewHolder.OnOderButtonClickedListener onOderButtonClicked = mOnOderButtonClicked;

        if ((dirtyFlags & 0x9L) != 0) {



                if (menu != null) {
                    // read menu.name
                    menuName = menu.getName();
                    // read menu.cost_for_one
                    menuCostForOne = menu.getCost_for_one();
                }
        }
        if ((dirtyFlags & 0xaL) != 0) {
        }
        // batch finished
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.btnPlaceOder.setOnClickListener(mCallback1);
        }
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.cartAdapterName, menuName);
            com.sorabh.grabfood.util.binding_adapter.BindingAdapterKt.txt(this.cartAdapterPrice, menuCostForOne);
        }
        if ((dirtyFlags & 0xaL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.cartAdapterSno, position);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // menu
        com.sorabh.grabfood.domain.model.restaurant_menu_response.Menu menu = mMenu;
        // onOderButtonClicked
        com.sorabh.grabfood.ui.adapter.CartViewHolder.OnOderButtonClickedListener onOderButtonClicked = mOnOderButtonClicked;
        // onOderButtonClicked != null
        boolean onOderButtonClickedJavaLangObjectNull = false;



        onOderButtonClickedJavaLangObjectNull = (onOderButtonClicked) != (null);
        if (onOderButtonClickedJavaLangObjectNull) {



            onOderButtonClicked.onOderButtonClicked(menu);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): menu
        flag 1 (0x2L): position
        flag 2 (0x3L): onOderButtonClicked
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}